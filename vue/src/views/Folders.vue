<template>
    <div>
    <h1>文件夹</h1>

    <Folder src="img/girl.jpeg" name="景"></Folder>
    <Folder src="img/girl.jpeg" name="风景"></Folder>
    <Folder src="img/warm.jpg" name="三个字"></Folder>
    <Folder src="img/warm.jpg" name="温馨小屋"></Folder>
    <Folder src="img/warm.jpg" name="三个字加俩"></Folder>
    <Folder src="img/warm.jpg" name="无敌盖世美图"></Folder>
    </div>
</template>

<script>
    import Folder from "../components/folder";
    export default {
        name: "Folders",
        components: {
            Folder,
        }
    }
</script>

<style scoped>

</style>