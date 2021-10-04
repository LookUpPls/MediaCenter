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
    allRates: Map,
    maxHeight: Number
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
          let stand;
          for (let allRatesKey in that.allRates) {
            stand = that.allRates[allRatesKey];
            break;
          }
          let rw = (origin.w / stand.x);
          let rh = (origin.h / stand.y);
          let wBTH;
          let ratio;
          if (rw >= rh) {
            wBTH = true;
            // 超宽
            ratio = Math.round(rw / rh);
          } else {
            wBTH = false;
            // 超长
            ratio = Math.round(rh / rw);
          }
          // 通过完整放大让其中一方=整数
          let ds = [1, 2, 3, 4, 5]
          let minD = Number.MAX_VALUE;
          let min = Number.MAX_VALUE;
          for (let i = 0; i < ds.length; i++) {
            let temp = ratio * ds[i];
            temp = Math.abs(Math.round(temp) - temp);
            if (temp < min) {
              min = temp;
              minD = ds[i];
            }
          }
          ratio = Math.round(ratio * minD);
          let nowRateO;
          if (wBTH) {
            nowRateO = {rate: ratio / minD, x: ratio, y: minD};
          } else {
            nowRateO = {rate: minD / ratio, x: minD, y: ratio}
          }
          // let minDiff = Number.MAX_VALUE;
          // let nowRateO;
          // // 选出合适的尺寸
          // for (let allRatesKey in that.allRates) {
          //   let rateO = that.allRates[allRatesKey];
          //   let diff = Math.abs(realRate - rateO.rate);
          //   if (diff < minDiff) {
          //     nowRateO = rateO;
          //     minDiff = diff;
          //   }
          // }
          console.log(nowRateO)
          let standHeight = that.blockHeight * nowRateO.y;
          let standWidth = that.blockWidth * nowRateO.x;
          // 放大
          if (realRate < nowRateO.rate) {
            if (standWidth / origin.w < 0.4) {
              standHeight *= 2;
              standWidth *= 2;
            }
          } else {
            if (standHeight / origin.h < 0.4) {
              standHeight *= 2;
              standWidth *= 2;
            }
          }

          that.style.gridColumn = "span " + parseInt(standWidth / that.gridSize);
          that.style.gridRow = "span " + parseInt(standHeight / that.gridSize);
          // if (realRate < nowRateO.rate) {
          //   // 高
          //   // 固定宽度,计算出高度
          //   let h = standWidth / origin.w * origin.h;
          //   // 把高度近似成倍数于单位块的.
          //   h = Math.round(h / standHeight) * standHeight;
          //   that.style.gridColumn = "span " + parseInt(standWidth / that.gridSize);
          //   that.style.gridRow = "span " + parseInt(h / that.gridSize);
          //   that.computedW = standWidth;
          //   that.computedH = h;
          // } else {
          //   // 宽
          //   let w = standHeight / origin.h * origin.w;
          //   w = Math.round(w / standWidth) * standWidth;
          //   that.style.gridColumn = "span " + parseInt(w / that.gridSize);
          //   that.style.gridRow = "span " + parseInt(standHeight / that.gridSize);
          //   that.computedW = w;
          //   that.computedH = standHeight;
          // }
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
