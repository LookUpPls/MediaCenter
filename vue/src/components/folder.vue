<template>
    <div style="width: 60px; height: 60px;">
        <img src="../assets/folder.svg" alt="" height="60px" width="60px" style="position:absolute">
        <img :src="src" alt="" height="28px" width="40px"
             style="position: relative; top: 0px;left: 10px; object-fit: cover">
        <div ref="container" :style="{backgroundImage:backImg}" class="container"></div>
        <div hidden="hidden" class="title-content">
            <p class="title">{{name}}</p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "folder",
        props: {name: String, src: String},
        data: function () {
            return {
                backImg: null
            }
        },

        created: function () {//生成自适应大小字体
            var c = document.createElement("canvas");
            c.width = 280;
            c.height = 200;
            var g = c.getContext('2d');
            g.fillStyle = "rgba(0,0,0,0)";
            g.fillRect(0, 0, 280, 200);

            g.fillStyle = "rgb(0,0,0)";
            var s = [this.$props.name];
            var h = [140];
            for (var i = 0; i < s.length; i++) {
                var length = s[i].length;
                var size = 270 / length; // 原宽 280px,左右留出 5px 的空隙量
                if (length === 1) {
                    g.font = 135 + "px ARIAL";
                    g.fillText(s[i], 70, h[i]);
                } else if (length === 2) {
                    g.font = size + "px ARIAL";
                    g.fillText(s[i], 7, h[i]);
                } else if (length === 3) {
                    g.font = size + "px ARIAL";
                    g.fillText(s[i], 7, h[i]);
                } else if (length === 4) {
                    g.font = size + "px ARIAL";
                    g.fillText(s[i], 5, h[i]);
                } else if (length === 5) {
                    g.font = size + "px ARIAL";
                    g.fillText(s[i], 5, h[i]);
                } else if (length === 6) {
                    g.font = size + "px ARIAL";
                    g.fillText(s[i], 5, h[i]);
                }
            }
            this.$data.backImg = 'url(' + c.toDataURL('image/png') + ')';
            // this.$refs.container.backgroundImage = 'url(' + c.toDataURL('image/png') + ')';
            // document.getElementById('container').style.backgroundImage = 'url(' + c.toDataURL('image/png') + ')';
        }
    }
</script>

<style scoped>
    .container {
        position: relative;
        left: 6px;
        width: 48px;
        height: 32px;
        transform: skew(-24deg, 0deg);
        background-repeat: no-repeat;
        background-size: contain;
    }

    .title {
        font-size: 16px;
        font-stretch: condensed;
        width: 48px;
        line-height: 15px;
        font-weight: 900;
        display: inline-block;
        vertical-align: middle;
        margin: 0;
        text-align: center;
    }

    .title-content {
        position: relative;
        left: 6px;
        width: 48px;
        height: 32px;
        transform: skew(-24deg, 0deg);
    }
</style>