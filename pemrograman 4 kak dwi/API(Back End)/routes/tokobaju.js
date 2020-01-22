const tokobaju = require('express')()

const tb = require('../controller/tokobaju')

tokobaju.post('/simpan', (req, res) => {
    console.log(req.body)
    tb.simpandata(req.body)
    .then(result => res.json(result))
    .catch(error => res.json(error))
  })

tokobaju.post('/simpanmkandroid', (req, res) => {
    tb.simpanmkandroid(req.body.id,req.body.nama,req.body.password,
        req.body.email,req.body.alamat,req.body.nohp)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

tokobaju.put('/updatemkandroid/:_id', (req, res) => {
  tb.updateMkAndroid(req.params._id,req.body.id,req.body.nama,req.body.password,
      req.body.email,req.body.alamat,req.body.nohp)
      .then(result => res.json(result))
      .catch(error => res.json(error))
})

tokobaju.delete('/deletemk/:id', (req, res) => {
    console.log(req.params.id)
    tb.hapusMatakuliah(req.params.id)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

tokobaju.get('/getmk/:id', (req, res) => {
    console.log(req.params.id)
    tb.getmatakuliahPermatakuliah(req.params.id)
        .then(result => res.json(result))
        .catch(error => res.json(error))
})

  tokobaju.get('/getmk', (req, res) => {
    tb.getmatakuliah()
      .then(result => res.json(result))
      .catch(error => res.json(error))
  })


module.exports = tokobaju
