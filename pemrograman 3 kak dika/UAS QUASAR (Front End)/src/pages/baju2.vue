<template>
<div class="q-pa-md">
    <q-toolbar class="bg-grey text-white shadow-2 rounded-borders">
    <q-btn flat label="Menu Utama" to="inputdata"/>
    <q-space />

    <!--
        notice shrink property since we are placing it
        as child of QToolbar
    -->
    <q-tabs v-model="tab" shrink>
        <q-btn name="KERANJANG" flat label="KERANJANG" to="keranjang" />
        <q-btn name="LOGOUT" label="LOGOUT" to="login" />
    </q-tabs>
    </q-toolbar>
    <!-- untukbaju -->
    <div class="q-pa-md">
    <q-img
      src="statics/baju2.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <h9>Putih</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju21.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <h9>Hitam</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju22.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <h9>Abu-Abu</h9>
      </div>
    </q-img>
    <q-page>
    <div class="row justify-center q-pt-md">
      <div class="col-md-5 col-xs-12">
        <q-card flat>
          <q-card-section>
            <div class="text-h4 q-pb-md text-center text-black"><b>Baju Lengan Panjang Garis Rp.210.000</b></div>
            <q-form
      @submit="onSubmit"
      @reset="onReset"
      class="q-gutter-sm"
    >
      <q-select filled v-model="ukuran" :options="listukuran" label="Ukuran" />
      <q-select filled v-model="warna" :options="listwarna" label="Warna - Code Baju" />
      <q-input
        filled
        v-model="jumlah"
        label="Masukkan Jumlah yang ingin dibeli"
        lazy-rules
        :rules="[ val => val !== '' && val !== null || 'Please type Your Total']"
      />
      <div>
        <q-btn label="Beli" type="submit" color="primary" />
        <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
        <q-btn label="Kembali" to="/inputdata" color="primary"/>
      </div>
    </q-form>
          </q-card-section>
        </q-card>
      </div>
    </div>
  </q-page>
</div>
</div>
</template>

<script>
export default {
  data () {
    return {
      listukuran: [
        'S - Rp.210.000',
        'M - Rp.210.000',
        'L - Rp.210.000',
        'XL - Rp.210.000',
        'XXL - Rp.210.000'
      ],
      listwarna: [
        'Putih - blpgp02',
        'Hitam - blpgh02',
        'Abu-Abu - blpga02'
      ],
      jumlah: ''
    }
  },
  methods: {
    onSubmit () {
      this.$axios.post('transaksi/posttransaksi', {
        ukuran: this.ukuran,
        warna: this.warna,
        jumlah: this.jumlah
      }).then(res => {
        if (res.data.error) {
          this.showNotif(res.data.pesan, 'negative')
        } else {
          this.showNotif(res.data.pesan, 'Positive')
        }
        this.onReset()
      })
    },
    onReset () {
      this.ukuran = ''
      this.warna = ''
      this.jumlah = ''
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
