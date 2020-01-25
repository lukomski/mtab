<template>
  <div class="content">
    <div class="container-fluid">

      <div class="row">
        <div>
          <p>
          
          </p>
          <!-- The modal -->
          <b-modal id="my-modal" @ok="modalApproved()" @cancel="modalCanceled()" :title="modal_input_text">
            <div>
              <div><b-button variant="danger" @click="modalDeleted()">Delete</b-button></div>
              <br>
              <p>Change Name value</p>
              <b-form-input v-model="modal_input_text" placeholder="Enter name"></b-form-input>
            </div>
          </b-modal>

          <!-- add city modal -->
          <b-modal id="add-city-modal" @ok="addCitymodalApproved()" @cancel="modalCanceled()" :title="add_modal_title">
            <div>
              <b-form-input v-model="add_modal_name_text" placeholder="Set Name value"></b-form-input>
              <b-form-input v-model="add_modal_info_text" placeholder="Set Info value"></b-form-input>
              <b-form-input v-model="add_modal_district_text" placeholder="Set District value"></b-form-input>
            </div>
          </b-modal>
        </div>

        <div class="col-12">
          <b-button variant="success" @click="openAddCityModal()">Add city</b-button>
          <br><br>
          <card class="strpied-tabled-with-hover"
                body-classes="table-full-width table-responsive"
          >
            <template slot="header">
              <h4 class="card-title">Cities table</h4>
<!--               <p class="card-category">Here is a subtitle for this table</p> -->
            </template>
<!--             <l-table class="table-hover table-striped table-sm"
                    @row-click='rowClicked()'
                     :columns="table1.columns"
                     :data="table1.data">
            </l-table> -->
            <b-table class="table-hover table-striped table-sm"
                @row-clicked="rowClicked"
                :items="table1.data"
            />
          </card>

        </div>

      </div>
    </div>
  </div>
</template>
<script>
  import LTable from 'src/components/Table.vue'
  import Card from 'src/components/Cards/Card.vue'
  import Api from '@/api'
  const tableColumns = ['Id', 'Name', 'District', 'Info']

  export default {
    components: {
      LTable,
      Card
    },
    data () {
      return {
        table1: {
          columns: [...tableColumns],
          data: []
        },
        table2: {
          columns: [...tableColumns],
          data: []
        },
        modal_input_text: '',
        modal_item: '',
        modal_index: '',
        modal_title: '',
        add_modal_title: 'Adding City',
        add_modal_name_text: '',
        add_modal_info_text: '',
        add_modal_district_text: ''
      }
    },
    methods: {
      updateCities: function () {
        console.log("updateCities")
        Api.getCities()
          .then(response => {
            console.log(response.data)
            this.table1 = {
              columns: [...tableColumns],
              data: response.data
            }
          })
          .catch(e => {
              alert(e)  
          })
      },
      modalApproved: function () {
        console.log("appoved " + this.modal_input_text)
        Api.setCityName(this.modal_item.id, this.modal_input_text)
          .then(response => {
            console.log(response.data)
            this.table1.data[this.modal_index].name = response.data.name
            console.log("@1")
            console.log(this.table1.data[this.modal_index])
          })
          .catch(e => {
            alert(e)  
          })
      },
      modalCanceled: function () {
        console.log("rejected " + this.modal_input_text)
      },
      modalDeleted: function () {
          console.log("delete" + this.modal_input_text)
          Api.deleteCity(this.modal_item.id)
            .then(response => {
              this.table1.data.splice(this.modal_index, 1)
            })
            .catch(e => {
              alert(e)  
            })
          this.$bvModal.hide("my-modal")
      },
      rowClicked: function (item, index) {
        this.modal_item = item
        this.modal_index = index
        this.modal_title = item.name
        this.modal_input_text = item.name
        this.$bvModal.show("my-modal")
      },
      openAddCityModal: function () {
        this.$bvModal.show("add-city-modal")
      },
      addCitymodalApproved: function () {
        console.log("add" + this.add_modal_name_text)
        Api.addCity(this.add_modal_name_text, this.add_modal_info_text, this.add_modal_district_text)
          .then(response => {
            this.table1.data.push(response.data)
          })
          .catch(e => {
            alert(e)  
          })
      }
    },
    mounted: function () {
      this.updateCities()
    }
  }
  import 'bootstrap/dist/css/bootstrap.css'
  import 'bootstrap-vue/dist/bootstrap-vue.css'
</script>

<style>
</style>
