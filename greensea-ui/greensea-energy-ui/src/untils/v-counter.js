// const directive = {
//     inserted(el, binding) {
//         // 获取到需要动态变化的数值
//         let finalNum = parseInt(el.innerText);
//         let count = 0;
//         let timer = setInterval(() => {
//             count++;
//             el.innerText = count;
//             if (count >= finalNum) {
//                 // 避免count大于finalNum最终数字显示不对
//                 el.innerText = finalNum;
//                 // 清空定时器
//                 clearInterval(timer);
//                 timer = null;
//             }
//         }, 10);
//     },
// };
// export default directive;
//
