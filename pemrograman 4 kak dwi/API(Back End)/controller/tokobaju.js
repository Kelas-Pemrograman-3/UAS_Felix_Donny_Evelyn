const tokobajuModel = require('../models/tokobaju')
const mongoose = require('mongoose')
const ObjectId = mongoose.Types.ObjectId;

exports.simpandata = (data) =>
new Promise((resolve, reject) => {
  tokobajuModel.create(data)
  .then(res => {
    resolve ({error: false,
    pesan: 'Data Terimput'})
  })
  .catch(res => {
    reject({
      error: true,
      pesan: 'Gaagal Terimput'
    })
  })
})


exports.simpanmkandroid = (id, nama, password, email, alamat, nohp) =>
    new Promise((resolve, reject) => {

      let data = new tokobajuModel({
        id: id,
        nama: nama,
        password: password,
        email: email,
        alamat: alamat,
        nohp: nohp
      });
      tokobajuModel.create(data)
          .then(res => {
            resolve ({error: false,
              pesan: 'Data Terimput'})
          })
          .catch(res => {
            reject({
              error: true,
              pesan: 'Gaagal Terimput'
            })
          })
    })


   exports.updateMkAndroid = (_id,id, nama, password, email,
                               alamat, nohp) =>
    new Promise(async (resolve, reject) => {

      // let query = {_id: ObjectId(req.params.id)};
      // console.log(dataMk)
      console.log("disini nih")

      await tokobajuModel.update(
          { _id: ObjectId(_id) },
          {
            $set: {
              id: id,
              nama: nama,
              password: password,
              email: email,
              alamat:alamat,
              nohp: nohp
            }
          })
          .then(res => {
            resolve ({error: false,
              pesan: 'Data Berhasil Dirubah'})
          })
          .catch(res => {
            console.log("disini")
            reject({
              error: true,
              pesan: 'Gaagal Dirubah'
            })
          })
    })


exports.hapusMatakuliah = (id) =>
    new Promise(async (resolve, reject) => {
      await tokobajuModel.remove({_id: ObjectId(id)})
          .then(res => {
            resolve ({error:false, pesan: 'Data Berhasil hapus'})
          })
          .catch(res => {
            console.log(error)
            reject ({error:true, pesan: 'Data gagal dihapus'})
          })
    })

exports.getmatakuliah = () =>
new Promise((resolve, reject) => {
  tokobajuModel.find()
  .then(res => {
    resolve ({error:false, pesan: 'Data Berhasil diambil', data: res})
  })
  .catch(res => {
    console.log(error)
    reject ({error:true, pesan: 'Data Tidak diambil'})
  })
})
