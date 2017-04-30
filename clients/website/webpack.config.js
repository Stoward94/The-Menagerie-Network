const path = require('path');

module.exports = {
  entry: "./src/index.js",
  output: {
    path: path.resolve(__dirname, "dist/js"),
    filename: "bundle.js",
    publicPath: "/js/"
  },
  devServer: {
    inline: true,
    contentBase: path.resolve(__dirname, "dist"),
    historyApiFallback: true,
    port: 3000
  },
  resolve: {
    modules: [
      "node_modules",
      path.resolve(__dirname, "src")
    ]
  },
  module:{
    rules: [
      {
        test: /\.jsx?$/,
        exclude: /(node_modules)/,
        loader: "babel-loader",
        query: {
          presets: ["latest", "stage-0", "react"]
        }
      },
      {
        test: /\.json$/,
        exclude: /(node_modules)/,
        loader: "json-loader"
      },
      {
        test: /\.css$/,
        exclude: /(node_modules)/,
        loader: "style-loader!css-loader!autoprefixer-loader"
      }
    ]
  }
}
