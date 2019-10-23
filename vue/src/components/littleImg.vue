<template>
    <img :height="height" :src="src" :width="width" alt="" class="img" ref="images">
</template>

<script>
    export default {
        name: "littleImg",
        props: {
            name: String,
            src: String,
            expect_height: Number
        },
        data: function () {
            return {
                width: 'auto',
                height: '172px'
            }
        },
        mounted() {
            this.getImgNaturalDimensions(this.$refs.images, this, function (othis, dimension) {
                console.log(othis.src);
                var scale = dimension.h / dimension.w;
                console.log(scale);
                if (scale > 1.5)
                    othis.height = othis.expect_height * 2 + "px";
                else
                    othis.height = othis.expect_height + "px";
            })
        },
        methods: {
            getImgNaturalDimensions: function (oImg, othis, callback) {
                var nWidth, nHeight;
                if (!oImg.naturalWidth) { // 现代浏览器

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

        object-fit: cover;
        border: 1px solid #666666;
    }

</style>