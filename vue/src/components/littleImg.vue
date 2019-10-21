<template>
    <img class="img" :src="src" alt="">
</template>

<script>
    export default {
        name: "littleImg",
        props: {name: String, src: String},
        data: function () {
            return {
                backImg: null
            }
        }
    }
</script>

<style scoped>
    .img {
        width: auto;
        height: 172px;
        object-fit: cover;
        border: 1px solid #666666;
    }

</style>