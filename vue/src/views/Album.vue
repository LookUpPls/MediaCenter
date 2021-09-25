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
      <div class="imgs"
           v-bind:style="{ display: 'grid', 'grid-template-rows': 'repeat(auto-fill,16px)', 'grid-template-columns': 'repeat(auto-fill,16px)',}">
        <littleImg @command="onCommand" :blockSize="blockSize" :gridSize="gridSize" :src="folder.src" name="folder.name"
                   v-for="folder in folderData"></littleImg>
      </div>
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
      gridStyle: {}
    }
  },
  components: {
    folder1,
    littleImg
  },
  computed: {
    blockSize: function () {
      let size = 312;
      let yv = size % this.gridSize;
      if (yv > this.gridSize / 2)
        size = size + this.gridSize - yv;
      else
        size -= yv;
      console.log(size)
      return size
    }
  },
  created() {
    getDir().then(response => {
      this.$data.folderData = response.data.folderData;
      this.$data.picData = response.data.picData;
    }).catch(err => {
      console.log(err);
      // reject(false);
    })
  },
  methods: {
    onCommand: function (info) {
      switch (info.order) {
        case "closeVideo":
          break;
      }
    },
    testMock1: function () {
      this.testMockVal = "clicked";
      console.log("clicked");
      testMock().then(response => {
        console.log(JSON.stringify(response.data));

      }).catch(err => {
        console.log(err)
        reject(false)
      })
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
  background-color: aliceblue;
}

.imgs > img {
  /*float: left;*/
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