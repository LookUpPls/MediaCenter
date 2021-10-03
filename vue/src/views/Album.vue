<template>
  <div class="home">
    <div>
      <p class="title">文件夹<span>共4个</span></p>
      <div class="folders">
        <folder1 :name="folder.name" :src="folder.src" v-for="folder in folderData"></folder1>
      </div>
    </div>
    <div>
      <p class="title">图片<span>共21个</span></p>
      <!--      <a-slider v-model="maxHeight" :min="1" :max="2000" @afterChange="locationImages"/>-->
      <a-slider v-model="maxHeight" :min="1" :max="2000" @change="locationImages"/>
      <div class="imgs" ref="images">
        <img :src="pic.src" :ref="pic.name" @load="loadOnePic(pic.name)" :height="pic.height" :id="pic.name"
             v-for="pic in pictures"/>
      </div>
      <a-slider v-model="maxHeight" :min="1" :max="2000" @change="locationImages"/>
    </div>
    <a-button @click="testMock1">{{ testMockVal }}</a-button>
  </div>
</template>

<script>
var axios = require('axios');
import {getDir} from '../api/album'

import folder1 from '@/components/folder1.vue'
import littleImg from '@/components/littleImg.vue'

export default {
  name: 'home',
  data: function () {
    return {
      gridSize: 28,
      testMockVal: "test",
      folderData: {},
      picData: {},
      pictures: {},
      picturesIndex: {},
      gridStyle: {},
      loadedImageCount: 0,
      maxHeight: 499,
      rows: [],
      exchanged: {},
      // c_aspectRatioDiff:1,
      // c_scalingDiff:
    }
  },
  components: {
    folder1,
    littleImg
  },
  watch: {
    loadedImageCount: function (now, old) {
      if (this.allImageCount === now) {
        this.locationImages();
      }
    }
  },
  computed: {
    allImageCount: function () {
      return this.folderData.length;
    },
  }
  ,
  created() {
    getDir().then(response => {
      this.$data.folderData = response.data.folderData;
      this.pictures = response.data.folderData;
      for (let key in this.pictures) {
        this.pictures[key].height = '100px';
        this.pictures[key].oHeight = null;
        this.pictures[key].oWidth = null;
        this.pictures[key].resolved = false;
        this.pictures[key].index = parseInt(key);
        this.picturesIndex[this.pictures[key].name] = this.pictures[key];
      }
      console.log('rquest completed')
      console.log(this.pictures);
      this.$data.picData = response.data.picData;
    }).catch(err => {
      console.log(err);
      // reject(false);
    })
  }
  ,
  methods: {
    quality:function (){
      let str ='';
      let sum = 0;
      for (let key in this.pictures) {
        str+='|'+this.pictures[key].scaling.toFixed(1);
        sum+=Math.abs(1-this.pictures[key].scaling);
      }
      console.log(sum.toFixed(2)+"|"+str);
    },
    computeRowHeight: function (rowIndex, h) {
      let width = this.$refs.images.clientWidth
      let row = this.rows[rowIndex];
      if (!!!h) {
        let aspectRatioSum = 0;
        for (let i = 0; i < row.length; i++) {
          let pic = this.pictures[row[i]];
          if (!!!pic.aspectRatio)
            pic.aspectRatio = pic.oWidth / pic.oHeight;
          aspectRatioSum += pic.aspectRatio;
        }
        h = width / aspectRatioSum;
      }
      for (let i = 0; i < row.length; i++) {
        let k = row[i];
        this.pictures[k].height = (h) + 'px';
        this.pictures[k].row = rowIndex;
        this.pictures[k].scaling = h / this.pictures[k].oHeight;
        this.$set(this.pictures, k, this.pictures[k]);
      }
    },
    locationImages: function () {
      // 计算位置
      this.exchanged = {};
      let row = [];
      let width = this.$refs.images.clientWidth
      let aspectRatioSum = 0;
      let h;
      for (let key in this.pictures) {
        let pic = this.pictures[key];
        if (!!!pic.aspectRatio)
          pic.aspectRatio = pic.oWidth / pic.oHeight;
        aspectRatioSum += pic.aspectRatio;
        row.push(key);
        h = width / aspectRatioSum;
        if (h < this.maxHeight) {
          this.rows.push(row);
          this.computeRowHeight(this.rows.length - 1, h);
          aspectRatioSum = 0;
          row = [];
        }
      }
      // 最后有没凑够一整行的
      if (row.length > 0) {
        let realWidth = aspectRatioSum * this.maxHeight;
        if (realWidth / width < 0.7)
          h = this.maxHeight;
        this.rows.push(row);
        this.computeRowHeight(this.rows.length - 1, h);
      }
      // todo: 像素替换计划, 把小像素但贼大的和大像素但贼小的交换一下位置,注意比例.
      // 从后边取
      let wooer;
      // 是否处理过
      let progressed;
      do {
        progressed = false;
        for (let key in this.pictures) {
          let pic = this.pictures[key];
          if (pic.scaling > 2) {
            wooer = pic;
            // 环绕循环
            let diff = 1;
            let endLeft;
            let endRight;
            let left = true;
            do {
              if (left) {
                endLeft = true;
                endRight = true;
              }
              let i;
              if (left)
                i = parseInt(key) - diff;
              else
                i = parseInt(key) + diff;
              // 交换  交换 row, 交换pictures ,
              if ((left && i > 0) || (!left && i < this.pictures.length)) {
                let pic1 = this.pictures[i];
                if (pic1.row !== pic.row && (parseInt(pic.height) / parseInt(pic1.height))>1.2 && Math.abs(pic1.aspectRatio - pic.aspectRatio) > 0.1 && pic1.scaling < 0.8 && !this.exchanged[pic.name + '_' + pic1.name]) {
                  // 记录下来交换过的行
                  // 计算每一行的新高度. row里记录的是pictures的元素index, 交换的时候直接把值交换过了,所以直接取值用就行.
                  this.exchangeLocation(pic, pic1);
                  this.exchanged[pic.name + '_' + pic1.name] = true;
                  progressed = true;
                  break;
                }
                if (left)
                  endLeft = false;
                else
                  endRight = false;
              }
              diff++;
              left = !left;
            } while (!(endLeft && endRight))
            if (progressed) break;
          }
        }
      } while (progressed)
      this.quality();
      // todo: 超高的像素往周围找匹配的伙伴.像素大而且也偏高的.
      // todo: 一竖加三横
    },
    exchangeLocation: function (pp1, pp2) {
      console.log(pp1.name + ' <---> ' + pp2.name);
      let il = pp1.index;
      let ir = pp2.index;
      let temp = this.pictures[il];
      this.pictures[il] = this.pictures[ir];
      this.pictures[ir] = temp;
      temp = this.pictures[il].index;
      this.pictures[il].index = this.pictures[ir].index;
      this.pictures[ir].index = temp;
      //important :  计算第一行的时候这个行号会改变
      let rowI = this.pictures[ir].row;
      this.computeRowHeight(this.pictures[il].row);
      this.computeRowHeight(rowI);
    },
    loadOnePic: function (name) {
      this.loadedImageCount++;
      let oImg = this.$refs[name];
      let pic = this.picturesIndex[name];
      if (oImg[0].naturalWidth) { // 现代浏览器
        pic.oWidth = oImg[0].naturalWidth;
        pic.oHeight = oImg[0].naturalHeight;
      } else { // IE6/7/8
        let nImg = new Image();
        nImg.onload = function (e) {
          pic.oWidth = e.target.width;
          pic.oHeight = e.target.height;
        };
        nImg.src = oImg[0].src;
      }
    },
    testMock1: function () {
      this.pictures[0].height = '500px'
      this.$set(this.pictures, 0, this.pictures[0])
    }
  }
}
</script>

<style>
.folders {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: flex-start;

  margin-bottom: 30px;

}

.imgs {
  margin: 10px;
  grid-auto-flow: row dense;
  background-color: black;
  grid-gap: 3px;
  /*overflow: hidden;*/
}

.imgs > img {
  /*float: left;*/
  /*object-fit: cover;*/
}

.folders > div {
  float: left;
  margin: 10px;
}

.title {
  font-family: 'Microsoft Tai Le Bold', 'Microsoft Tai Le Regular', 'Microsoft Tai Le';
  font-weight: 700;
  font-style: normal;
  font-size: 20px;
  color: rgba(0, 0, 0, 0.847058823529412);
  line-height: 28px;
  letter-spacing: 2px;

  margin-bottom: 5px;
}

.title > span {
  margin-left: 8px;
  font-family: 'Microsoft Tai Le';
  font-weight: 400;
  font-style: normal;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.447058823529412);
  line-height: 22px;
}
</style>