module.exports = {  //配置按需加载，这个babel插件就是干这个的
    presets: ["@vue/app"],
    plugins: [
        [
            "import",
            {libraryName: "ant-design-vue", libraryDirectory: "es", style: true}
        ]
    ]
};
