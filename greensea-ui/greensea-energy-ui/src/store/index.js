//vuex,
import {createApp} from 'vue'
import { createStore} from 'vuex'
export default createStore({
    state:{
        newProductId:'',
    },
    mutations:{
        setNewProductId(state,id){
            state.id = id
        }
    },
    actions:{
        updateProduct({commit},id){
            commit('setNewProductId', id);
        }
    },
    getters:{
        newProductId:state =>state.newProductId
    }
})



