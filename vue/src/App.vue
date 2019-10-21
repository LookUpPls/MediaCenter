<template>
    <a-layout id="components-layout-demo-custom-trigger">
        <a-layout-sider :trigger="null" collapsible v-model="collapsed" style="background: #fff" width="150" >
            <div class="logo"><img src="./assets/logo.png" alt="" width="40px" height="40px"/></div>
            <a-menu theme="light" mode="inline" :defaultSelectedKeys="['1']">
                <a-menu-item key="1">
                    <router-link to="/">
                        <a-icon type="picture"/>
                        <span>相册</span>
                    </router-link>
                </a-menu-item>
                <a-menu-item key="2">
                    <router-link to="/folders">
                        <a-icon type="folder-open"/>
                        <span>分类</span>
                    </router-link>
                </a-menu-item>
                <a-menu-item key="3">
                    <router-link to="/device">
                        <a-icon type="mobile"/>
                        <span>设备</span>
                    </router-link>
                </a-menu-item>
                <a-menu-item key="4">
                    <router-link to="/scan">
                        <a-icon type="security-scan"/>
                        <span>扫描本机</span>
                    </router-link>
                </a-menu-item>
                <a-menu-item key="5">
                    <router-link to="/log">
                        <a-icon type="profile"/>
                        <span>操作记录</span>
                    </router-link>
                </a-menu-item>
                <a-menu-item key="6">
                    <router-link to="/about">
                        <a-icon type="exclamation-circle"/>
                        <span> 关于 </span>
                    </router-link>
                </a-menu-item>
            </a-menu>
        </a-layout-sider>
        <a-layout>
            <a-layout-header style="background: #fff; padding: 0">
                <a-icon class="trigger" :type="collapsed ? 'menu-unfold' : 'menu-fold'"
                        @click="()=> collapsed = !collapsed"/>
            </a-layout-header>
            <a-layout-content :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }">
                <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
                    <router-view/>
                </div>
            </a-layout-content>
        </a-layout>
    </a-layout>
</template>
<script>
    export default {
        data() {
            return {
                collapsed: false,
            };
        },
    };
</script>

<style>
    #components-layout-demo-custom-trigger .trigger {
        font-size: 18px;
        line-height: 64px;
        padding: 0 24px;
        cursor: pointer;
        transition: color 0.3s;
    }

    #components-layout-demo-custom-trigger .trigger:hover {
        color: #1890ff;
    }

    #components-layout-demo-custom-trigger .logo {
        height: 32px;
        background: rgba(255, 255, 255, 0.2);
        margin: 16px;
    }

    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
    }

    #nav {
        padding: 30px;
    }

    #nav a {
        font-weight: bold;
        color: #2c3e50;
    }

    #nav a.router-link-exact-active {
        color: #42b983;
    }
</style>
