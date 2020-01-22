const mongoose = require('mongoose')
const Schema = mongoose.Schema

const transaksi = new Schema({
  ukuran: {
    type: String
  },
  warna: {
    type: String
  },
  jumlah: {
    type: String
  }
})

module.exports = mongoose.model('transaksi', transaksi)