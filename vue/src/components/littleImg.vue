<template>
  <div :style="style">
    <img :src="src" alt="" @mouseenter="mouseEnter" @mouseleave="mouseLeave"
         :style="{width:width,height:height,objectFit: objectFit }"
         class="img" ref="image">
  </div>
</template>

<script>
export default {
  name: "littleImg",
  props: {
    name: String,
    src: String,
    gridSize: [Number, String],
    blockWidth: [Number, String],
    blockHeight: [Number, String],
    allRates: Map
  },
  data: function () {
    return {
      oW: 0,
      oH: 0,
      computedW: 0,
      computedH: 0,
      width: '100%',
      height: '100%',
      objectFit: 'cover',
      style: {
        gridRow: "span 1",
        gridColumn: "span 1",
        overflow: "hidden",
      }
    }
  },
  computed: {
    standRate: function () {
      return this.blockWidth / this.blockHeight;
    }
  },
  mounted() {
    this.getImgNaturalDimensions(this.$refs.image, this,
        function (that, origin) {
          that.oW = origin.w;
          that.oH = origin.h;
          let realRate = origin.w / origin.h;
          let minDiff = Number.MAX_VALUE;
          let nowRateO;
          for (let allRatesKey in that.allRates) {
            let rateO = that.allRates[allRatesKey];
            let diff = Math.abs(realRate - rateO.rate);
            if (diff < minDiff) {
              nowRateO = rateO;
              minDiff = diff;
            }
          }
          console.log(nowRateO)
          let standHeight = that.blockHeight * nowRateO.y;
          let standWidth = that.blockWidth * nowRateO.x;
          if (realRate < nowRateO.rate) {
            // 高
            // 固定宽度,计算出高度
            let h = standWidth / origin.w * origin.h;
            // 把高度近似成倍数于单位块的.
            h = Math.round(h / standHeight) * standHeight;
            that.style.gridColumn = "span " + parseInt(standWidth / that.gridSize);
            that.style.gridRow = "span " + parseInt(h / that.gridSize);
            that.computedW = standWidth;
            that.computedH = h;
          } else {
            // 宽
            let w = standHeight / origin.h * origin.w;
            w = Math.round(w / standWidth) * standWidth;
            that.style.gridColumn = "span " + parseInt(w / that.gridSize);
            that.style.gridRow = "span " + parseInt(standHeight / that.gridSize);
            that.computedW = w;
            that.computedH = standHeight;
          }
        })
  },
  methods: {
    mouseEnter: function () {
      this.objectFit = 'contain';
    },
    mouseLeave: function () {
      this.objectFit = 'cover';
    },
    getImgNaturalDimensions: function (oImg, that, callback) {
      // console.log(oImg)
      var nWidth, nHeight;
      if (oImg.naturalWidth) { // 现代浏览器

        nWidth = oImg.naturalWidth;
        nHeight = oImg.naturalHeight;
        callback(that, {w: nWidth, h: nHeight});

      } else { // IE6/7/8
        var nImg = new Image();

        nImg.onload = function () {
          var nWidth = nImg.width,
              nHeight = nImg.height;
          callback(that, {w: nWidth, h: nHeight});
        };
        nImg.src = oImg.src;
      }
    }
  }
}
</script>

<style scoped>
.img {
  /*width: 100%;*/
  /*height: 100%;*/
  /*object-fit: cover;*/
  /*border: 1px solid #666666;*/
}

</style>