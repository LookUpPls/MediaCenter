<template>
    <div class="container">
        <img class="img" :src="src" alt="" height="28px" width="40px">

        <div class="title-out2">
            <div class="title-out1">
                <p>&nbsp;{{name}}&nbsp;</p>
            </div>
        </div>

        <div style="width: 195px;height:30px;">

            <p style="text-align: left; position:relative;top:8px; left: 5px;">
                <span
                        style="font-family:'Microsoft Tai Le Bold', 'Microsoft Tai Le Regular', 'Microsoft Tai Le';font-weight:700;">5</span><span
                    style="font-family:'Microsoft Tai Le';font-weight:400;"> 个文件夹</span></p>

            <p style="text-align: right; position:relative;top:-29px; right: 5px;"><span
                    style="font-family:'Microsoft Tai Le Bold', 'Microsoft Tai Le Regular', 'Microsoft Tai Le';font-weight:700;">45</span><span
                    style="font-family:'Microsoft Tai Le';font-weight:400;">/</span><span
                    style="font-family:'Microsoft Tai Le Bold', 'Microsoft Tai Le Regular', 'Microsoft Tai Le';font-weight:700;">5</span><span
                    style="font-family:'Microsoft Tai Le';font-weight:400;"> 个文件</span></p>
        </div>
    </div>
</template>

<script>
    export default {
        name: "folder1",
        props: {name: String, src: String},
        data: function () {
            return {
                backImg: null
            }
        }
    }
</script>

<style scoped>

    .container {
        width: 195px;
        height: 172px;
        border-radius: 10px;
        border: 1px solid rgb(221, 221, 221);

        position: relative;
        background: inherit;
        background-color: rgba(255, 255, 255, 1);
        box-sizing: border-box;
        border-color: rgba(221, 221, 221, 1);
        box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.349019607843137);
    }


    .img {
        border-width: 0;
        position: relative;
        left: -1px;
        top: -1px;
        width: 195px;
        height: 134px;
        border-radius: 5px 5px 0 0;
        object-fit: cover;
    }

    .title-out2 {
        position: relative;
        /* left: 26px; */
        top: -34px;
        right: 0px;
        /* float: right; */
        /* padding: 0px; */
        /* margin: 10px; */
    }

    .title-out1 {
        width: fit-content;
        border-radius: 5px;
        float: right;
        background-color: white;
        height: 27px;
        margin-right: 2px;
    }

    .title-out1 > p {
        font-family: 'Microsoft Tai Le Bold', 'Microsoft Tai Le Regular', 'Microsoft Tai Le';
        font-weight: 700;
        font-style: normal;
        font-size: 20px;
        color: rgba(0, 0, 0, 0.847058823529412);
        line-height: 28px;

        /*文字左边留白*/
        text-indent: 3px;
        /*文字间隔和右边留白*/
        letter-spacing: 3px;
    }
</style>