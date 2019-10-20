<template>
    <div class="home">
        <img alt="Vue logo" src="../assets/logo.png">
        <HelloWorld msg="Welcome to Your Vue.js App"/>
        <a-button @click="testMock">{{testMockVal}}</a-button>
    </div>
</template>

<script>
    var axios = require('axios');
    import {Button} from 'ant-design-vue';

    Vue.component(Button.name, Button);

    import Vue from "vue";
    import HelloWorld from '@/components/HelloWorld.vue'


    export default {
        name: 'home',
        data: function () {
            return {

                testMockVal: "test"
            }
        },
        components: {
            HelloWorld
        },
        methods: {
            testMock: function () {
                this.testMockVal = "clicked";
                // eslint-disable-next-line no-console
                console.log("clicked");
                axios.post('/testMock', {
                    firstName: 'Fred',
                    lastName: 'Flintstone'
                })
                    .then(function (response) {
                        // eslint-disable-next-line no-console
                        console.log(JSON.stringify(response));
                    })
                // .catch(function (error) {
                // });
            }
        }
    }
</script>
