module.exports = {
  devServer: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080', // The backend server
        changeOrigin: true,
      },
    },
  },
};
