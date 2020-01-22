const transaksi = require('express')()

const t = require('../controller/transaksi')

transaksi.post('/simpan', (req, res) => {
    console.log(req.body)
    t.simpandata(req.body)
    .then(result => res.json(result))
    .catch(error => res.json(error))
  })

transaksi.post('/simpanmkandroid', (req, res) => {
    t.simpanmkandroid(req.body.ukuran,req.body.warna,req.body.jumlah)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

transaksi.put('/updatemkandroid/:_id', (req, res) => {
  t.updateMkAndroid(req.params._id,req.body.ukuran,req.body.warna,req.body.jumlah)
      .then(result => res.json(result))
      .catch(error => res.json(error))
})

transaksi.delete('/deletemk/:id', (req, res) => {
    console.log(req.params.id)
    t.hapusMatakuliah(req.params.id)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

transaksi.get('/getmk/:id', (req, res) => {
    console.log(req.params.id)
    t.getmatakuliahPermatakuliah(req.params.id)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

  transaksi.get('/getmk', (req, res) => {
    t.getmatakuliah()
      .then(result => res.json(result))
      .catch(error => res.json(error))
  })


module.exports = transaksi
