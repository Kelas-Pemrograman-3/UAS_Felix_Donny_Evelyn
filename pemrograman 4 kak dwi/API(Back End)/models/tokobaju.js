const mongoose = require('mongoose')
const Schema = mongoose.Schema

const tokobaju = new Schema({
  id: {
    type: String,
    required: true
  },
  nama: {
    type: String
  },
  password: {
    type: String
  },
  email: {
    type: String
  },
  alamat: {
    type: String
  }, 
  nohp: {
    type: String
  }
})

module.exports = mongoose.model('tokobaju', tokobaju)