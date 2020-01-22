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
        <q-btn name="KERANJANG" flat label="KERANJANG" to="keranjang"/>
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
        <q-btn name="baju3" label="Pilih" to="baju2"/>
        <h9>Rp.210.000</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju3.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <q-btn name="baju2" label="Pilih" to="baju3"/>
        <h9>Rp.210.000</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju4.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <q-btn name="baju4" label="Pilih" to="baju4"/>
        <h9>Rp.200.000</h9>
      </div>
    </q-img>
  </div>
  <div class="q-pa-md">
    <q-img
      src="statics/baju5.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <q-btn name="baju5" label="Pilih" to="baju5"/>
        <h9>Rp.200.000</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju6.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <q-btn name="baju6" label="Pilih" to="baju6"/>
        <h9>Rp.230.000</h9>
      </div>
    </q-img>
    <q-img
      src="statics/baju7.jpg"
      spinner-color="white"
      style="height: 450px; max-width: 420px"
      img-class="my-custom-image"
      class="rounded-borders">
      <div class="absolute-bottom text-subtitle1 text-center">
        <q-btn name="baju7" label="Pilih" to="baju7"/>
        <h9>Rp.230.000</h9>
      </div>
    </q-img>
  </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      tab: ''
    }
  }
}
</script>
