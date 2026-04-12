import readline from 'readline';
//好讨厌没有确定输入个数的情况，需要根据输入内容动态判断！！！！！！
//懒得写了，直接ctrl+c退出，查看结果，反正算法平台会自动处理输入输出
function prefixSum() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let inputLines = []; //这是输入的每一行，包括n和m，以及n个数，以及m个查询
    rl.on('line', (line) => { //line事件，当输入一行时触发，用于处理输入数据
        inputLines.push(line.trim()); //trim()方法用于移除字符串首尾的空格字符
    });

    rl.on('close', () => { //close事件，当输入完成时触发，用于处理输入数据
        // 读取项数 n
        const n = parseInt(inputLines[0]); //输入的是字符串，需要转换为整数

        // 使用前缀和，复杂度控制在 O(1)
        let sum = new Array(n);
        sum[0] = parseInt(inputLines[1]);

        // 计算前缀和数组
        for (let i = 1; i < n; i++) {
            let value = parseInt(inputLines[i + 1]); 
            sum[i] = sum[i - 1] + value;
        }

        // 处理区间和查询
        for (let i = n + 1; i < inputLines.length; i++) {
            let [left, right] = inputLines[i].split(' ').map(Number);

            if (left === 0) {
                console.log(sum[right]);
            } else {
                console.log(sum[right] - sum[left - 1]);
            }
        }
    });
}

prefixSum();