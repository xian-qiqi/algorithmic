var generateMatrix = function(n) {
    let startX = 0,startY = 0;   // 起始位置
    let loop = Math.floor(n/2);   // 旋转圈数
    let mid = Math.floor(n/2);    // 中间位置
    let offset = 1;    // 控制每一层填充元素个数
    let count = 1;     // 更新填充数字
    //二维数组初始化
    // let res = new Array(n).fill(0).map(() => new Array(n).fill(0));
    let res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = new Array(n).fill(0);
    }

    while (loop--) {
        let row = startX, col = startY;
        // 上行从左到右（左闭右开）
        for (; col < n - offset; col++) {
            res[row][col] = count++;
        }
        // 右列从上到下（左闭右开）
        for (; row < n - offset; row++) {
            res[row][col] = count++;
        }
        // 下行从右到左（左闭右开）
        for (; col > startY; col--) {
            res[row][col] = count++;
        }
        // 左列做下到上（左闭右开）
        for (; row > startX; row--) {
            res[row][col] = count++;
        }

        // 更新起始位置
        startX++;
        startY++;

        // 更新offset
        offset += 1;
    }
    // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
    if (n % 2 === 1) {
        res[mid][mid] = count;
    }
    return res;
};

import readline from 'readline/promises';
import { stdin as input, stdout as output } from 'process';

const rl = readline.createInterface({ input, output });
//得到字符串，不要使用解构赋值，否则会报错
// 使用await异步函数，需要在async函数中使用----特殊点--允许在顶层使用await，即不在函数里面
//promises方法，对比于下面的回调函数方法，更简洁，async/await语法底层基于promises实现，
//await用于promises对象上
const n = await rl.question("请输入n值：");
rl.close();
console.log(generateMatrix(Number(n)));


//在屏幕上输入n值，都是用字符串ES6语法实现
//nodejs里面没有prompt函数，需要使用readline模块实现
// import readline from 'readline';
// const rl = readline.createInterface({
//     input: process.stdin,
//     output: process.stdout
// });
// // let n = rl.question("请输入n值："); //question是异步函数，需要使用回调函数处理结果
// //使用回调函数
// rl.question("请输入n值：", (answer) => {
//     const n = Number(answer);
//     console.log(generateMatrix(n));
//     rl.close();
// });
