<template>
  <div :style="style">
    <img :src="src" alt="" class="img" ref="image">
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
    blockHeight: [Number, String]
  },
  data: function () {
    return {
      style: {
        gridRow: "span 1",
        gridColumn: "span 1",
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
        function (othis, dimension) {
          if (dimension.w / dimension.h < othis.standRate) {
            // 高
            let h = othis.blockWidth / dimension.w * dimension.h;
            h = Math.round(h / othis.blockHeight) * othis.blockHeight;
            othis.style.gridColumn = "span " + parseInt(othis.blockWidth / othis.gridSize);
            othis.style.gridRow = "span " + parseInt(h / othis.gridSize);
          } else {
            // 宽
            let w = othis.blockHeight / dimension.h * dimension.w;
            w = Math.round(w / othis.blockWidth) * othis.blockWidth;
            othis.style.gridColumn = "span " + parseInt(w / othis.gridSize);
            othis.style.gridRow = "span " + parseInt(othis.blockHeight / othis.gridSize);
          }
        })
  },
  methods: {
    getImgNaturalDimensions: function (oImg, othis, callback) {
      // console.log(oImg)
      var nWidth, nHeight;
      if (oImg.naturalWidth) { // 现代浏览器

        nWidth = oImg.naturalWidth;
        nHeight = oImg.naturalHeight;
        callback(othis, {w: nWidth, h: nHeight});

      } else { // IE6/7/8
        var nImg = new Image();

        nImg.onload = function () {
          var nWidth = nImg.width,
              nHeight = nImg.height;
          callback(othis, {w: nWidth, h: nHeight});
        };
        nImg.src = oImg.src;
      }
    }
  }
}
</script>

<style scoped>
.img {
  width: 100%;
  height: 100%;
  /*object-fit: cover;*/
  /*border: 1px solid #666666;*/
}

</style>