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
    blockSize: [Number, String]
  },
  data: function () {
    return {
      style: {
        gridRow: "span 1",
        gridColumn: "span 1",
      }
    }
  },
  mounted() {
    this.getImgNaturalDimensions(this.$refs.image, this,
        function (othis, dimension) {
          // console.log(othis);
          // console.log(othis.src);
          // console.log(dimension);
          if (dimension.h >= dimension.w) {
            othis.style.gridColumn = "span " + parseInt(othis.blockSize / othis.gridSize);
            othis.style.gridRow = "span " + parseInt(othis.blockSize * dimension.h / dimension.w / othis.gridSize);
          } else {
            othis.style.gridRow = "span " + parseInt(othis.blockSize / othis.gridSize);
            othis.style.gridColumn = "span " + parseInt(othis.blockSize * dimension.w / dimension.h / othis.gridSize);
          }
          var scale = dimension.w / dimension.h;
          console.log(scale);
          //
          // if (scale > 1.5)
          //     othis.height = othis.gridSize * 2 + "px";
          // else
          //     othis.height = othis.gridSize + "px";
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