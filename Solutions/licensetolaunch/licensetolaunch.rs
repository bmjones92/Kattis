use std::io;

fn main() {
    let mut num_days = String::new();
    io::stdin().read_line(&mut num_days).ok();
    let num_days : i32 = num_days.trim().parse().unwrap();

    let mut days = String::new();
    io::stdin().read_line(&mut days).ok();

    let days: Vec<i32> = days.trim().split_whitespace().map(|day| day.parse().unwrap()).collect();

    let mut min_value = days[0];
    let mut min_index = 0;
    for (index, value) in days.iter().enumerate() {
        if *value < min_value {
            min_index = index;
            min_value = *value;
        }
    }

    println!("{}", min_index);
}