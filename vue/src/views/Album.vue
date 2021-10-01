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
import {testMock} from '../api/testMock'
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
        this.picturesIndex[this.pictures[key].name] = this.pictures[key];
      }
      this.$data.picData = response.data.picData;
    }).catch(err => {
      console.log(err);
      // reject(false);
    })
  }
  ,
  methods: {
    locationImages: function () {
      // 计算位置
      let row = [];
      let width = this.$refs.images.clientWidth
      let rateSum = 0;
      let h;
      for (let key in this.pictures) {
        let pic = this.pictures[key];
        rateSum += (pic.oWidth / pic.oHeight);
        row.push(key);
        h = width / rateSum;
        console.log(h);
        if (h < this.maxHeight) {
          for (let i = 0; i < row.length; i++) {
            let k = row[i];
            this.pictures[k].height = (h) + 'px';
            this.$set(this.pictures, k, this.pictures[k]);
          }
          rateSum = 0;
          row = [];
        }
      }
      // 最后有没凑够一整行的
      if (row.length > 0) {
        let realWidth = rateSum * this.maxHeight;
        if (realWidth / width < 0.7)
          h = this.maxHeight;
        for (let i = 0; i < row.length; i++) {
          let k = row[i];
          this.pictures[k].height = h + 'px';
          this.$set(this.pictures, k, this.pictures[k]);
        }
      }
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