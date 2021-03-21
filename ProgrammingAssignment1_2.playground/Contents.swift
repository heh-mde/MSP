
import Foundation

// Частина 1

// Дано рядок у форматі "Student1 - Group1; Student2 - Group2; ..."

let studentsStr = "Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82"

// Завдання 1
// Заповніть словник, де:
// - ключ – назва групи
// - значення – відсортований масив студентів, які відносяться до відповідної групи

var studentsGroups: [String: [String]] = [:]

// Ваш код починається тут

let students = studentsStr.components(separatedBy: "; ")

var studentsInfo: [[String]] = []
for item in students{
    let student = item.components(separatedBy: " - ")
    studentsInfo.append(student)
}

for item in studentsInfo{
    if studentsGroups[item[1]] != nil{
        studentsGroups[item[1]]?.append(item[0])
    }
    else{
        studentsGroups[item[1]] = []
        studentsGroups[item[1]]?.append(item[0])
    }
}

for (key, _) in studentsGroups{
    studentsGroups[key]?.sort()
}

// Ваш код закінчується тут

print("Завдання 1")
print(studentsGroups)
print()

// Дано масив з максимально можливими оцінками

let points: [Int] = [12, 12, 12, 12, 12, 12, 12, 16]

// Завдання 2
// Заповніть словник, де:
// - ключ – назва групи
// - значення – словник, де:
//   - ключ – студент, який відносяться до відповідної групи
//   - значення – масив з оцінками студента (заповніть масив випадковими значеннями, використовуючи функцію `randomValue(maxValue: Int) -> Int`)

func randomValue(maxValue: Int) -> Int {
    switch(arc4random_uniform(6)) {
    case 1:
        return Int(ceil(Float(maxValue) * 0.7))
    case 2:
        return Int(ceil(Float(maxValue) * 0.9))
    case 3, 4, 5:
        return maxValue
    default:
        return 0
    }
}

var studentsPoints: [String: [String: [Int]]] = [:]

// Ваш код починається тут

for (key, value) in studentsGroups{
    studentsPoints[key] = [:]
    for student in value{
        var studentPoints: [Int] = []
        for point in points{
            studentPoints.append(randomValue(maxValue: point))
        }
        studentsPoints[key]![student] = studentPoints
    }
}

// Ваш код закінчується тут

print("Завдання 2")
print(studentsPoints)
print()

// Завдання 3
// Заповніть словник, де:
// - ключ – назва групи
// - значення – словник, де:
//   - ключ – студент, який відносяться до відповідної групи
//   - значення – сума оцінок студента

var sumPoints: [String: [String: Int]] = [:]

// Ваш код починається тут

for (group, students) in studentsPoints{
    sumPoints[group] = [:]
    for (student, points) in students{
        var sumPoint: Int = 0
        for point in  points{
            sumPoint += point
        }
        sumPoints[group]![student] = sumPoint
    }
}

// Ваш код закінчується тут

print("Завдання 3")
print(sumPoints)
print()

// Завдання 4
// Заповніть словник, де:
// - ключ – назва групи
// - значення – середня оцінка всіх студентів групи

var groupAvg: [String: Float] = [:]

// Ваш код починається тут

for (group, students) in sumPoints{
    var groupSum: Int = 0
    for (_, point) in students{
        groupSum += point
    }
    groupAvg[group] = Float(groupSum) / Float(students.count)
}

// Ваш код закінчується тут

print("Завдання 4")
print(groupAvg)
print()

// Завдання 5
// Заповніть словник, де:
// - ключ – назва групи
// - значення – масив студентів, які мають >= 60 балів

var passedPerGroup: [String: [String]] = [:]

// Ваш код починається тут

for (group, students) in sumPoints {
    passedPerGroup[group] = []
    for (student, point) in students{
        if point >= 60{
            passedPerGroup[group]?.append(student)
        }
    }
}

// Ваш код закінчується тут

print("Завдання 5")
print(passedPerGroup)

class TimeAB {
    let hour : UInt
    let min : UInt
    let sec : UInt
    
    init(){
        hour = 0
        min = 0
        sec = 0
    }
    init?(_ hour: UInt, _ min: UInt, _ sec: UInt){
        if (hour < 0) || (hour > 23) || (min < 0) || (min > 59) || (sec < 0) || (sec > 59){
            return nil
        }
        self.hour = hour
        self.min = min
        self.sec = sec
    }
    init(_ date: Date){
        let calendar = Calendar.current
        hour = UInt(calendar.component(.hour, from: currentDate))
        min = UInt(calendar.component(.minute, from: currentDate))
        sec = UInt(calendar.component(.second, from: currentDate))
    }
    func getDate() -> String{
        let format : String
        var hourFormated : UInt = hour
        if (hour > 12){
            format = "PM"
            hourFormated -= 12
        }
        else{
            format = "AM"
        }
        return("\(hourFormated):\(min):\(sec) \(format)")
    }
    func sumOfTimes(_ timeOut: TimeAB) -> TimeAB?{
        var resHour : UInt = 0
        var resMin : UInt = 0
        var resSec : UInt
        
        resSec = sec + timeOut.sec
        if (resSec > 59){
            resSec -= 60
            resMin += 1
        }
        resMin += min + timeOut.min
        if (resMin > 59){
            resMin -= 60
            resHour += 1
        }
        resHour += hour + timeOut.hour
        if (resHour > 23){
            resHour -= 24
        }
        return(TimeAB(resHour, resMin, resSec))
    }
    func difOfTimes(_ timeOut: TimeAB) -> TimeAB?{
        var resHour : Int = 0
        var resMin : Int = 0
        var resSec : Int
        
        resSec = Int(sec) - Int(timeOut.sec)
        if (resSec < 0){
            resSec += 60
            resMin -= 1
        }
        resMin += Int(min) - Int(timeOut.min)
        if (resMin < 0){
            resMin += 60
            resHour -= 1
        }
        resHour += Int(hour) - Int(timeOut.hour)
        if (resHour < 0){
            resHour += 24
        }
        return(TimeAB(UInt(resHour), UInt(resMin), UInt(resSec)))
    }
    class func sumOfTimes(_ time1 : TimeAB, _ time2 : TimeAB) -> TimeAB?{
        var resHour : UInt = 0
        var resMin : UInt = 0
        var resSec : UInt
        
        resSec = time1.sec + time2.sec
        if (resSec > 59){
            resSec -= 60
            resMin += 1
        }
        resMin += time1.min + time2.min
        if (resMin > 59){
            resMin -= 60
            resHour += 1
        }
        resHour += time1.hour + time2.hour
        if (resHour > 23){
            resHour -= 24
        }
        return(TimeAB(resHour, resMin, resSec))
    }
    class func difOfTimes(_ time1 : TimeAB, _ time2 : TimeAB) -> TimeAB?{
        var resHour : Int = 0
        var resMin : Int = 0
        var resSec : Int
        
        resSec = Int(time1.sec) - Int(time2.sec)
        if (resSec < 0){
            resSec += 60
            resMin -= 1
        }
        resMin += Int(time1.min) - Int(time2.min)
        if (resMin < 0){
            resMin += 60
            resHour -= 1
        }
        resHour += Int(time1.hour) - Int(time2.hour)
        if (resHour < 0){
            resHour += 24
        }
        return(TimeAB(UInt(resHour), UInt(resMin), UInt(resSec)))
    }
}

print()
print("Завдання 6")
print("Init with type Data:")
let currentDate = Date()
var TimeFromDate : TimeAB = TimeAB(currentDate)
print(" Hour:",TimeFromDate.hour)
print(" Minute:",TimeFromDate.min)
print(" Second:",TimeFromDate.sec)
print(" Formated time:",TimeFromDate.getDate())

print()
print("Init with default time:")
var DefaultTime : TimeAB = TimeAB()
print(" Hour:",DefaultTime.hour)
print(" Minute:",DefaultTime.min)
print(" Second:",DefaultTime.sec)
print(" Formated time:",DefaultTime.getDate())

print()
print("Init with time from User:")
if let TimeFromUser = TimeAB(7, 43, 19){
    print(" Hour:",TimeFromUser.hour)
    print(" Minute:",TimeFromUser.min)
    print(" Second:",TimeFromUser.sec)
    print(" Formated time:",TimeFromUser.getDate())
}
else{
    print("Exception: incorrect time entered")
}

print()
print("Init with wrong parameter from User:")
if let TimeFromUser = TimeAB(7, 78, 19){
}
else{
    print(" Exception: incorrect time entered")
}

var TimeFromUser1 : TimeAB = TimeAB(11, 32, 54)!
print()
print("Test of summing and subtracting methods:")
print(" Time from caller:")
print("   Hour:",TimeFromUser1.hour)
print("   Minute:",TimeFromUser1.min)
print("   Second:",TimeFromUser1.sec)
print(" Time from parameter:")
print("   Hour:",TimeFromDate.hour)
print("   Minute:",TimeFromDate.min)
print("   Second:",TimeFromDate.sec)
print(" Sum:")
var TimeRes : TimeAB = TimeFromUser1.sumOfTimes(TimeFromDate)!
print("   Hour:",TimeRes.hour)
print("   Minute:",TimeRes.min)
print("   Second:",TimeRes.sec)
print(" Dif:")
TimeRes = TimeFromUser1.difOfTimes(TimeFromDate)!
print("   Hour:",TimeRes.hour)
print("   Minute:",TimeRes.min)
print("   Second:",TimeRes.sec)

var TimeFromUser2 : TimeAB = TimeAB(17, 3, 12)!
print()
print("Test of summing and subtracting class methods:")
print(" Time 1:")
print("   Hour:",TimeFromUser1.hour)
print("   Minute:",TimeFromUser1.min)
print("   Second:",TimeFromUser1.sec)
print(" Time 2:")
print("   Hour:",TimeFromUser2.hour)
print("   Minute:",TimeFromUser2.min)
print("   Second:",TimeFromUser2.sec)
print(" Sum:")
TimeRes = TimeAB.sumOfTimes(TimeFromUser1, TimeFromUser2)!
print("   Hour:",TimeRes.hour)
print("   Minute:",TimeRes.min)
print("   Second:",TimeRes.sec)
print(" Dif:")
TimeRes = TimeAB.difOfTimes(TimeFromUser1, TimeFromUser2)!
print("   Hour:",TimeRes.hour)
print("   Minute:",TimeRes.min)
print("   Second:",TimeRes.sec)
