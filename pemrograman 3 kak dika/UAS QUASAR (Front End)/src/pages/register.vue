<template>
  <q-page>
    <div class="row justify-center q-pt-md">
      <div class="col-md-5 col-xs-12">
        <q-card flat>
          <q-img
      src="statics/registerr.png"
      spinner-color="white"
      style="height: 200px; max-width: 600px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <h9>REGISTER</h9>
      </div>
    </q-img>
          <q-card-section>
            <q-form
      @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-sm"
    >
      <q-input
        filled
        type="number"
        v-model="id"
        label="Ketik ID Anda"
        lazy-rules
        :rules="[
          val => val !== null && val !== '' || 'Please type your ID']"
      />

      <q-input
        filled
        v-model="nama"
        label="Ketik Nama Anda"
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Please type your Nama']"
      />

      <q-input
        filled
        type="Password"
        v-model="password"
        label="Ketik Password Anda"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Password']"
      />
      <q-input
        filled
        v-model="email"
        label="Ketik Email Anda"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Email']"
      />
      <q-input
        filled
        v-model="alamat"
        label="Ketik Alamat Anda"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Alamat']"
      />
      <q-input
        filled
        v-model="nohp"
        label="Ketik Nomor Hp Anda"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Phone Number']"
      />
      <div>
        <q-btn label="REGIST" type="submit" color="primary" />
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
        <q-btn label="Kembali" to="/login" color="primary"/>
      </div>
    </q-form>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</template>

<script>
export default {
  data () {
    return {
      id: '',
      nama: '',
      password: '',
      email: '',
      alamat: '',
      nohp: ''
    }
  },
  methods: {
    onSubmit () {
      this.$axios.post('tokobaju/posttokobaju', {
        id: this.id,
        nama: this.nama,
        password: this.password,
        email: this.email,
        alamat: this.alamat,
        nohp: this.nohp
      }).then(res => {
        if (res.data.error) {
          this.showNotif(res.data.pesan, 'negative')
        } else {
          this.showNotif(res.data.pesan, 'Positive')
        } this.onReset()
      })
    },
    onReset () {
      this.id = ''
      this.nama = ''
      this.password = ''
      this.email = ''
      this.alamat = ''
      this.nohp = ''
    },
    showNotif (msg, color) {
      this.$q.notify({
        message: msg,
        color: color
      })
    }
  }
}
</script>
