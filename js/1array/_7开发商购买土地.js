import readline from 'readline';
function main() {
    // const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    })
    let inputLines = []
    rl.on('line', function (line) {
        inputLines.push(line.trim())//trim()方法用于移除字符串首尾的空格字符
    })
    rl.on('close', function () {
        let [n, m] = inputLines[0].split(" ").map(Number)
        // 构建land矩阵
        let land = []
        for (let i = 0; i < n; i++) {
            land[i] = inputLines[i + 1].split(" ").map(Number)
        }
        // buyLand(land, m, n)
        buyLand(land)
    })
}

function buyLand(land){
    let n = land.length
    let m = land[0].length
    let row = new Array(n).fill(0)  //用于记录行的前缀和
    let col = new Array(m).fill(0)  //用于记录列的前缀和
    let minGap = Infinity;
    
    //计算前缀和
    for(let i=0;i<n;i++){
        let temp = 0
        for (let j = 0; j < m; j++) {
            temp += land[i][j]
        }
        row[i] = i === 0 ? temp : temp + row[i - 1];
    }
    for(let i=0;i<m;i++){
        let temp = 0
        for (let j = 0; j < n; j++) {
            temp += land[j][i]
        }
        col[i] = i === 0 ? temp : temp + col[i - 1];
    }

    //计算最小差值
    // 计算水平切分的最小差值
    for (let i = 0; i < n; i++) {
        let rowGap = Math.abs((row[n - 1] - row[i]) - row[i])
        minGap = Math.min(minGap, rowGap)
    }
    
    // 计算垂直切分的最小差值
    for (let i = 0; i < m; i++) {
        let colGap = Math.abs((col[m - 1] - col[i]) - col[i])
        minGap = Math.min(minGap, colGap)
    }
    console.log(minGap);
}

main()