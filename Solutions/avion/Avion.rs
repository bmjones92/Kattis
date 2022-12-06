use std::io;
use std::io::BufRead;

fn main() {
    let result: Vec<usize> = io::stdin()
        .lock()
        .lines()
        .enumerate()
        .filter_map(|(idx, name)|
            if name.unwrap().contains("FBI") {
                Some(idx + 1)
            } else {
                None
            }
        ).collect();

    if result.is_empty() {
        println!("HE GOT AWAY!");
    } else {
        for id in result {
            print!("{} ", id);
        }
    }
}