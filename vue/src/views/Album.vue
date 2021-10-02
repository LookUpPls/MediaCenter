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
      maxHeight: 435,
      rows: [],
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
      console.log(this.pictures);
      this.$data.picData = response.data.picData;
    }).catch(err => {
      console.log(err);
      // reject(false);
    })
  }
  ,
  methods: {
    computeRowHeight: function (rowIndex, h) {
      console.log(rowIndex)
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
      let row = [];
      let width = this.$refs.images.clientWidth
      let aspectRatioSum = 0;
      let h;
      let lastRow;
      for (let key in this.pictures) {
        let pic = this.pictures[key];
        if (!!!pic.aspectRatio)
          pic.aspectRatio = pic.oWidth / pic.oHeight;
        aspectRatioSum += pic.aspectRatio;
        row.push(key);
        h = width / aspectRatioSum;
        console.log(h);
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
      console.log(this.pictures)
      console.log(this.rows)
      // todo: 像素替换计划, 把小像素但贼大的和大像素但贼小的交换一下位置,注意比例.
      // 从后边取
      let wooer;
      for (let key in this.pictures) {
        let pic = this.pictures[key];
        if (pic.scaling > 2) {
          console.log(pic)
          console.log(pic.index)
          console.log(pic.name)
          wooer = pic;
          // 环绕循环
          let diff = 1;
          let endLeft = true;
          let endRight = true;
          do {
            endLeft = true;
            endRight = true;
            if (parseInt(key) - diff > 0) {
              let pic1 = this.pictures[parseInt(key) - diff];
              if (pic1.scaling < 0.5 && Math.abs(pic1.aspectRatio - pic.aspectRatio) < 1 && pic1.row !== pic.row) {
                let il = pic.index;
                let ir = pic1.index;
                let temp = this.pictures[il];
                this.pictures[il] = this.pictures[ir];
                this.pictures[ir] = temp;
                temp = this.pictures[il].index;
                this.pictures[il].index = this.pictures[ir].index;
                this.pictures[ir].index = temp;
                // temp = this.pictures[pic.index].row;
                // this.pictures[pic.index].row = this.pictures[pic1.index].row;
                // this.pictures[pic1.index].row = temp;
                this.computeRowHeight(this.pictures[il].row);
                this.computeRowHeight(this.pictures[ir].row);
                console.log(this.pictures);
                break;
              }
              endLeft = false;
            }
            if (parseInt(key) + diff < this.pictures.length) {
              let pic1 = this.pictures[parseInt(key) + diff];

              endRight = false;
            }
            diff++;
          } while (!(endLeft && endRight))
        }
      }
      let maxer = {};
      let miner = {};
      // 统计缩放异常的
      // 交换  交换 row, 交换pictures ,
      // 记录下来交换过的行
      // 计算每一行的新高度. row里记录的是pictures的元素index, 交换的时候直接把值交换过了,所以直接取值用就行.

      // todo: 超高的像素往周围找匹配的伙伴.像素大而且也偏高的.
      // todo: 一竖加三横
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