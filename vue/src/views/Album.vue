<template>
    <div class="home">
        <div>

            <p class="title">文件夹<span>共4个</span></p>
            <div class="folders">

                <folder1 src="img/girl.jpeg" name="test"></folder1>
                <folder1 src="img/blackBorder.jpg" name="test"></folder1>
                <folder1 src="img/girlInBed.jpg" name="test"></folder1>
                <folder1 src="img/car.jpg" name="test"></folder1>
                <folder1 src="img/girl.jpeg" name="test"></folder1>
                <folder1 src="img/girl.jpeg" name="test"></folder1>
                <folder1 src="img/girl.jpeg" name="test"></folder1>
                <folder1 src="img/girl.jpeg" name="test"></folder1>
            </div>
        </div>
        <div>

            <p class="title">图片<span>共21个</span></p>
            <div class="folders" style="margin: 10px;">

                <littleImg src="img/blackBorder.jpg" name="test"></littleImg>
                <littleImg src="img/girlInBed.jpg" name="test"></littleImg>
                <littleImg src="img/car.jpg" name="test"></littleImg>
            </div>
        </div>
        <a-button @click="testMock1">{{testMockVal}}</a-button>
    </div>
</template>

<script>
    var axios = require('axios');
    import {testMock} from '../api/testMock'

    import folder1 from '@/components/folder1.vue'
    import littleImg from '@/components/littleImg.vue'

    export default {
        name: 'home',
        data: function () {
            return {
                testMockVal: "test"
            }
        },
        components: {
            folder1,
            littleImg
        },
        methods: {
            testMock1: function () {
                this.testMockVal = "clicked";
                // eslint-disable-next-line no-console
                console.log("clicked");
                // axios.post('/testMock', {
                //     firstName: 'Fred',
                //     lastName: 'Flintstone'
                // })
                //     .then(function (response) {
                //         // eslint-disable-next-line no-console
                //         console.log(JSON.stringify(response));
                //     })
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