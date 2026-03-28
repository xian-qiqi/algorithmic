import readline from 'readline';

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var minSubArrayLen = function(target, nums) {
    let start, end
    start = end = 0
    let sum = 0
    let len = nums.length
    //Infinity 表示正无穷大，用于初始化 ans 以确保后续的比较能够更新 ans
    let ans = Infinity
    
    while(end < len){
        sum += nums[end];
        while (sum >= target) {
            ans = Math.min(ans, end - start + 1);
            sum -= nums[start];
            start++;
        }
        end++;
    }
    return ans === Infinity ? 0 : ans
};

console.log('=== 最小子数组长度算法 ===');
console.log('请输入目标值和数组（用逗号分隔数字）\n');

rl.question('请输入目标值: ', (targetInput) => {
    rl.question('请输入数组: ', (arrayInput) => {
        const target = parseInt(targetInput);
        const nums = arrayInput.split(',').map(num => parseInt(num.trim()));
        
        if (isNaN(target)) {
            console.log('错误: 目标值必须是数字');
            rl.close();
            return;
        }
        
        if (nums.some(isNaN)) {
            console.log('错误: 数组必须包含有效数字');
            rl.close();
            return;
        }
        
        // console.log(`\n输入的目标值: ${target}`);
        // console.log(`输入的数组: [${nums}]`);
        
        const result = minSubArrayLen(target, nums);
        console.log(`计算结果: ${result}`);

        rl.close();
    });
});