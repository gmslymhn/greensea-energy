// import { createMemoryHistory, createRouter } from 'vue-router'
import { createRouter as _createRouter, createWebHashHistory } from 'vue-router'
// import {ElMessage} from 'element-plus'
// import {useStore} from 'vuex'

import HomeView from '../views/home/MyHome.vue'
import LoginView from '../views/Login/PageLogin.vue'
import SignPage from "@/views/Sign/SignPage.vue";
import NewProduct from '../views/home/components/NewProductPage.vue'

//算了，直接自己配置吧
const routes = [
    {
        path:'/',
        component : HomeView,
        meta: {header: true}
    },
    {
        path: '/login',
        component: LoginView,
        meta:{ header:false}
    },
    {
        path:'/sign',
        component: SignPage,
        meta: {header: false}

    },
    {
        path: '/newProduct',
        component: NewProduct,
        meta:{header: false}
    }
];



export function createRouter() {
    const router = _createRouter({
        history: createWebHashHistory(),
        routes,
        scrollBehavior(to,from,savedPosition){
            if(to.hash){
                return {
                    el:to.hash,
                    behavior:'smooth',
                };
            }
            else if(savedPosition){
                return savedPosition
            }
            else{
                return {top:0}
            }
        }
    });

    return router
}








