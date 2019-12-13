const webpack = require('webpack');
const config = require('./webpack.config');
const path = require('path');
const nodeExternals = require('webpack-node-externals');

const dist = 'dist';
module.exports = {
  ...config,
  entry: ['webpack/hot/poll?1000', './dist/main.js'],
  watch: true,
  externals: [
    nodeExternals({
      whitelist: ['webpack/hot/poll?1000'],
    }),
  ],
  mode: 'development',
  devtool: 'inline-cheap-source-map',
  output: {
    path: path.join(__dirname, dist),
    filename: 'server.js',
  },
  plugins: [new webpack.HotModuleReplacementPlugin(), ...config.plugins],
};