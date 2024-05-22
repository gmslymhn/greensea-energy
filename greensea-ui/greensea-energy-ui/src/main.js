// main.js
import { createApp } from 'vue';
import ElementPlus from 'element-plus'
// import 'element-plus/dist/index.css'
import App from './App.vue';
import { createRouter } from './router';
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import './assets/css/element.scss'
import couter from './untils/v-counter'
const app = createApp(App);
const router = createRouter();

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}
app.use(couter)

app.use(router);
app.use(ElementPlus)
app.mount('#app');

