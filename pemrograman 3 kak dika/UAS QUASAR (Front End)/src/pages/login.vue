<template>
  <q-page>
      <div class="row justify-center q-pt-md">
      <div class="col-md-4 col-xs-10" >
        <q-card flat>
          <q-img
      src="statics/halamanlogin.jpg"
      spinner-color="white"
      style="height: 180px; max-width: 500px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <h9>MENU LOGIN</h9>
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
        label="Masukkan ID"
        lazy-rules
        :rules="[
          val => val !== null && val !== '' || 'Please type your ID']"
      />

      <q-input
        filled
        type="Password"
        v-model="password"
        label="Masukkan Password"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Password']"
      />

      <div>
        <q-btn label="Login" type="submit"  color="primary"/>
        <q-btn label="Regist" to="/register" color="primary" flat class="q-ml-sm" />
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
      password: ''
    }
  },
  methods: {
    onSubmit () {
      this.$axios.post('tokobaju/login', {
        id: this.id,
        password: this.password
      }).then(res => {
        if (res.data.error) {
          this.showNotif(res.data.pesan, 'negative')
        } else {
          // this.showNotif(res.data.pesan, 'Positive')
          this.$router.push('/inputdata')
        }
        this.onReset()
      })
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
