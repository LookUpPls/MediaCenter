<template>
    <a-layout id="components-layout-demo-custom-trigger">
        <a-layout-sider :trigger="null" collapsible v-model="collapsed">
            <div class="logo"/>
            <a-menu theme="dark" mode="inline" :defaultSelectedKeys="['1']">
                <a-menu-item key="1">
                    <a-icon type="user"/>
                    <span>nav 1</span>
                </a-menu-item>
                <a-menu-item key="2">
                    <a-icon type="video-camera"/>
                    <span>nav 2</span>
                </a-menu-item>
                <a-menu-item key="3">
                    <a-icon type="upload"/>
                    <span>nav 3</span>
                </a-menu-item>
            </a-menu>
        </a-layout-sider>
        <a-layout>
            <a-layout-header style="background: #fff; padding: 0">
                <a-icon
                        class="trigger"
                        :type="collapsed ? 'menu-unfold' : 'menu-fold'"
                        @click="()=> collapsed = !collapsed"
                />
            </a-layout-header>
            <a-layout-content
                    :style="{ margin: '24px 16px', padding: '24px', background: '#fff', minHeight: '280px' }"
            >
                <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
                    <router-link to="/">Home</router-link>
                    |
                    <router-link to="/about">About</router-link>

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
