const nextMonth = new Date().getMonth() + 3;
const myCalender = new CalendarPicker('#myCalendarWrapper', {
    showShortWeekdays: true,
    min: new Date(),
    max: new Date(new Date().getFullYear(), nextMonth)
});

const currentToDateString = document.querySelector(".current-date");
const urlParams = new URLSearchParams(window.location.search);
if (urlParams.has("dateString")) {
    let dateString = urlParams.get("dateString");
    let dateNew = new Date(Date.parse(dateString));
    let monthDay = dateNew.getDate() + 1
    dateNew.setDate(monthDay);
    myCalender.value = dateNew;
    myCalender.calendarGrid.querySelectorAll("time").forEach(element => {
        element.classList.remove('selected')
        if (element.textContent == monthDay) {
            element.classList.add('selected');
        }
    });
    document.getElementById("dateString").value = dateString;
}

currentToDateString.textContent = myCalender.value.toDateString();

myCalender.onValueChange((currentValue) => {
    currentToDateString.textContent = currentValue.toDateString();
    let url = new URL(location.href)
    url.searchParams.set('dateString', currentValue.toISOString().split('T')[0]);
    location.href = url.href;
});


document.querySelector(".time_elements").addEventListener("click", (ev) => {
    console.log(ev.target.textContent);
    document.getElementById("timeString").value = ev.target.textContent;
    document.querySelector(".appointment_form").submit();
})