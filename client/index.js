var app = new Vue({
  el: "#app",
  components: {
    vuejsDatepicker,
  },
  data: {
    dateFrom: null,
    dateTo: null,
    carId: null,
    rentersId: null,
    carByModelId: null,
    nomer: null,
    nomerAdd: null,
    error: null,
    errorText: null,
    fio: null,
    modelCar: {
      id: null,
      name: null,
    },
    modelCarArr: [this.modelCar],
    historyTime: { name: null, result: null },
    historyTimeArr: [this.historyTime],
    car: {
      id: null,
      modelCar: {
        id: null,
        name: null,
      },
      nomer: null,
    },
    cars: [this.car],
    renter: {
      id: null,
      name: null,
      surname: null,
      patronymic: null,
    },
    renters: [this.renter],
    carsHistory1: {
      id: null,
      car: {
        id: null,
        modelCar: {
          id: null,
          name: null,
        },
        nomer: null,
      },
      renter: {
        id: null,
        name: null,
        surname: null,
        patronymic: null,
      },
      dateFrom: null,
      dateTo: null,
    },
    carsHistory: [this.carsHistory1],
  },
  methods: {
    getRenter: function () {
      axios
        .get("http://localhost:8080/renter/all")
        .then((response) => (this.renters = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCar: function () {
      axios
        .get("http://localhost:8080/car/all")
        .then((response) => (this.cars = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarHistory: function () {
      axios
        .get("http://localhost:8080/historyCarsRented/all")
        .then((response) => (this.carsHistory = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    customFormatter(date) {
      return moment(date).format("yyyy-MM-DD");
    },
    addCar: function () {
      this.car.modelCar.id = this.carByModelId;
      this.car.nomer = this.nomerAdd;
      axios
        .post("http://localhost:8080/car/addCar", this.car)
        .then((response) => {
          this.car = response.data.data;
          $("#carModal").modal("hide");
          this.getCar();
        })
        .catch((error) => (window.location.href = "error.html"));
    },
    addRentor: function () {
      axios
        .post("http://localhost:8080/renter/addRenter", this.renter)
        .then((response) => {
          this.rentor = response.data.data;
          $("#rentorModal").modal("hide");
          this.getRenter();
        })
        .catch((error) => (window.location.href = "error.html"));
    },
    addCarHistory: function () {
      this.carsHistory1.car.id = this.carId;
      this.carsHistory1.renter.id = this.rentersId;
      this.carsHistory1.dateFrom = this.dateFrom;
      this.carsHistory1.dateTo = this.dateTo;
      axios
        .post(
          "http://localhost:8080/historyCarsRented/addHistoryCarsRented",
          this.carsHistory1
        )
        .then((response) => {
          this.carsHistory1 = response.data.data;
          $("#HistoryModal").modal("hide");
          this.getCarHistory();
          this.getHistoryTime();
        })
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarHistoryByModelCar: function () {
      axios
        .get(
          "http://localhost:8080/historyCarsRented/getHistoryByCarId?id=" +
            this.carId
        )
        .then((response) => (this.carsHistory = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarHistoryByRenter: function () {
      axios
        .get(
          "http://localhost:8080/historyCarsRented/getHistoryByRenter?id=" +
            this.rentersId
        )
        .then((response) => (this.carsHistory = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarByNomer: function () {
      axios
        .get("http://localhost:8080/car/findByNomer?nomer=" + this.nomer)
        .then((response) => (this.car = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarByModelId: function () {
      axios
        .get("http://localhost:8080/car/carByModelId?id=" + this.carByModelId)
        .then((response) => (this.cars = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getCarByNomerLike: function () {
      axios
        .get("http://localhost:8080/car/carByModelLike?nomer=" + this.nomer)
        .then((response) => {
          this.cars = response.data.data;
          if (this.nomer == "" && this.cars == null) {
            this.getCar();
          }
        })
        .catch((error) => (window.location.href = "error.html"));
    },
    getRenterByFioLike: function () {
      axios
        .get("http://localhost:8080/renter/getByFio?fio=" + this.fio)
        .then((response) => {
          this.renters = response.data.data;
          if (this.fio == "" && this.renters == null) {
            this.getRenter();
          }
        })
        .catch((error) => (window.location.href = "error.html"));
    },
    getModelCar: function () {
      axios
        .get("http://localhost:8080/modelcar/all")
        .then((response) => (this.modelCarArr = response.data.data))
        .catch((error) => (window.location.href = "error.html"));
    },
    getHistoryTime: function () {
      this.historyTimeArr = [];
      axios
        .get("http://localhost:8080/historyCarsRented/getTimeForRentetModelCar")
        .then((response) => {
          for (let i = 0; i < response.data.data.length; i++) {
            this.historyTime = {
              name: response.data.data[i].split(/[,]+/)[0],
              result: response.data.data[i].split(/[,]+/)[1],
            };
            this.historyTimeArr.push(this.historyTime);
          }
        })
        .catch((error) => (window.location.href = "error.html"));
    },
  },
  watch: {
    nomer: function () {
      this.debouncedGetAnswer();
    },
    fio: function () {
      this.debouncedGetAnswerFio();
    },
  },
  filters: {
    formatDate1: function (value) {
      if (value) {
        return moment(String(value)).format("yyyy-MM-DD");
      }
    },
  },
  created: function () {
    this.debouncedGetAnswer = _.debounce(this.getCarByNomerLike, 500);
    this.debouncedGetAnswerFio = _.debounce(this.getRenterByFioLike, 500);
  },
  mounted() {
    this.getHistoryTime();
    this.getCar();
    this.getRenter();
    this.getCarHistory();
    this.getModelCar();
  },
});
