
const config = {
    entry: './main.js',
    output: {
        filename: 'index.html'
    },
    module: {
        rules: [
            { test: /\.txt$/, use: 'raw-loader' }
        ]
    }
};

module.exports = config;
