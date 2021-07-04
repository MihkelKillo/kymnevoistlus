Vue.component('ala-component', {
    props: ['alaprop'],
    template: '<li>{{ alaprop.ala }} -- Tulemus: <input v-model.number=alaprop.tulemus></input> {{alaprop.yhik}}   -- Punkte: {{ alaprop.skoor }}</li>'
  })

var app = new Vue({
    el: '#app',
    data: {
        alad: [
        { id: 0, ala: '100 m jooks', tulemus: 0.0, skoor: 0.0, yhik: 'sekundit'},
        { id: 1, ala: 'kaugushüpe', tulemus: 0.0, skoor: 0.0, yhik: 'sentimeetrit' },
        { id: 2, ala: 'kuulitõuge', tulemus: 0.0, skoor: 0.0, yhik: 'meetrit' },
        { id: 3, ala: 'kõrgushüpe', tulemus: 0.0, skoor: 0.0, yhik: 'sentimeetrit' },
        { id: 4, ala: '400 m jooks', tulemus: 0.0, skoor: 0.0, yhik: 'sekundit' },
        { id: 5, ala: '110 m tõkkejooks', tulemus: 0.0, skoor: 0.0, yhik: 'sekundit' },
        { id: 6, ala: 'kettaheide', tulemus: 0.0, skoor: 0.0, yhik: 'meetrit' },
        { id: 7, ala: 'teivashüpe', tulemus: 0.0, skoor: 0.0, yhik: 'sentimeetrit' },
        { id: 8, ala: 'odavise', tulemus: 0.0, skoor: 0.0, yhik: 'meetrit' },
        { id: 9, ala: '1500 m jooks', tulemus: 0.0, skoor: 0.0, yhik: 'sekundit' }
        ],
        skoorKokku: 0,
        tulemusedMap: new Map(),
        tulemusedDto: {
            tulemusedMap: {}
        },
        skooridMap: new Map()
    },
    methods: {
        arvutaSkoor: function () {
            this.alad.forEach(ala => {
                this.tulemusedMap.set(ala.ala, ala.tulemus)
            });
            this.tulemusedDto.tulemusedMap = Object.fromEntries(this.tulemusedMap)
            const requestOptions = {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(this.tulemusedDto)
            };
            fetch("http://localhost:8080/kymnevoistlus", requestOptions)
                .then(response => response.json())
                .then(data => (
                    this.skoorKokku = data.summa,
                    this.skooridMap = new Map(Object.entries(data.skooridMap)),
                    this.alad.forEach(ala => {
                        ala.skoor = this.skooridMap.get(ala.ala);
                    })));
        },
        onlyNumbers: function(tulemus) {
            tulemus = tulemus.replace(/[^0-9.]/g,'');
        }
    }

})