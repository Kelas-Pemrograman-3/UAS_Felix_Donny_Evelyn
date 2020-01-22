const transaksiModel = require('../models/transaksi')
const mongoose = require('mongoose')
const ObjectId = mongoose.Types.ObjectId;

exports.simpandata = (data) =>
new Promise((resolve, reject) => {
  transaksiModel.create(data)
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


exports.simpanmkandroid = (ukuran, warna, jumlah) =>
    new Promise((resolve, reject) => {

      let data = new transaksiModel({
        ukuran: ukuran,
        warna: warna,
        jumlah: jumlah
      });
      transaksiModel.create(data)
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


   exports.updateMkAndroid = (_id,ukuran, warna, jumlah) =>
    new Promise(async (resolve, reject) => {

      // let query = {_id: ObjectId(req.params.id)};
      // console.log(dataMk)
      console.log("disini nih")

      await transaksiModel.update(
          { _id: ObjectId(_id) },
          {
            $set: {
              ukuran: ukuran,
              warna: warna,
              jumlah: jumlah
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
      await transaksiModel.remove({_id: ObjectId(id)})
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
  transaksiModel.find()
  .then(res => {
    resolve ({error:false, pesan: 'Data Berhasil diambil', data: res})
  })
  .catch(res => {
    console.log(error)
    reject ({error:true, pesan: 'Data Tidak diambil'})
  })
})
