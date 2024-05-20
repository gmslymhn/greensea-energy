import { defHttp } from '@/utils/http/axios';
import { getMenuListResultModel } from './model/menuModel';

//这个就是获取菜单的接口
enum Api {
  GetMenuList = '/getMenuList',
}

/**
 * @description: Get user menu based on id
 */

export const getMenuList = () => {
  return defHttp.get<getMenuListResultModel>({ url: Api.GetMenuList });
};
