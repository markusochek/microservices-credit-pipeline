export function jsDatepicker(el) {
    datepicker(el, {
        formatter: (entry, date) => {entry.value = date.toLocaleDateString()},
        startDay: 1,
        customMonths: ['Январь', 'Февраль', 'Март', 'Апрель', 'Май', 'Июнь',
            'Июль', 'Август', 'Сентябрь', 'Октябрь', 'Ноябрь', 'Декабрь'],
        customDays: ['Вс', 'Пн', 'Вт', 'Ср', 'Чт', 'Пт', 'Сб']
    })
}