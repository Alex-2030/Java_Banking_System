# Java Banking System

A desktop banking application written in Java with a Swing GUI. It lets a bank employee log in, manage customer accounts, and process deposits, withdrawals, and transfers. All data is stored in plain text files, so there is no database to set up.

## Features

- Employee login screen
- Open new accounts (Current or Savings)
- View all accounts, with search and sort
- Modify account details
- Close accounts
- Deposit, withdraw, and transfer between accounts
- Per-account transaction history
- Input validation for usernames, amounts, and account details

## Tech stack

- Java 21 (project is configured for JDK 21)
- Swing (GUI, Nimbus look and feel)
- Text-file storage (`DB/`)

## Project structure

```
.
├── src
│   ├── gui          # Swing windows (Login, Menu, Deposit, Withdraw, Transfer, ...)
│   ├── management   # Business logic: Accounts, Users, Transactions
│   └── validate     # Input validation
├── DB
│   ├── users.txt        # Login credentials (one "username password" per line)
│   ├── accounts.txt     # One account per line
│   └── <account>.txt    # Transaction log for each account
└── Imgs                 # Icons used by the GUI
```

## Requirements

- JDK 21 or newer (a JRE alone is not enough, you need `javac` to compile)

Check with:

```
java -version
javac -version
```

## Running the app

> **Important:** run the app from the **project root folder** (the one containing `DB/` and `Imgs/`). The code loads data and images using relative paths, so running from anywhere else will fail to find them.

The entry point is `gui.Login`.

### Option 1: IntelliJ IDEA (easiest)

1. Open the project folder in IntelliJ (`File > Open`).
2. Make sure the project SDK is set to JDK 21 (`File > Project Structure > Project`).
3. Open `src/gui/Login.java`.
4. Click the green arrow next to `public static void main` and choose **Run 'Login.main()'**.
5. If images or data are missing, go to `Run > Edit Configurations` and set **Working directory** to the project root.

### Option 2: Command line (Windows)

From the project root:

```
mkdir out
javac -d out src\gui\*.java src\management\*.java src\validate\*.java
java -cp out gui.Login
```

### macOS / Linux

The code currently builds file paths with Windows-style backslashes (for example `"DB\\users.txt"` and `"Imgs\\Bank.png"`), so it only works on Windows as-is. To run it elsewhere, replace those with forward slashes (or `File.separator`). In `Deposit.java`, also change `deposit.png` to `Deposit.png`, since other operating systems treat file names as case-sensitive. Then compile and run:

```
mkdir -p out
javac -d out src/gui/*.java src/management/*.java src/validate/*.java
java -cp out gui.Login
```

## Logging in

Credentials are read from `DB/users.txt`, one `username password` pair per line. To add a user, add a new line in that format. The sample data includes demo accounts, for example:

| Username | Password |
|---|---|
| `Alex.A` | `1234@Alex` |

## Data format

**`DB/accounts.txt`**: one account per line:

```
accountNumber,name,email,balance,phone,openDate,type
7598612650,Alex Alex,Alex@gmail.com,10.00,01123914814,02-01-2025,Current
```

**`DB/<accountNumber>.txt`**: transaction log for that account:

```
accountNumber,type,amount,date,description
```

## Notes and limitations

- Passwords are stored in plain text and the sample data is committed to the repo. This project is for learning purposes and is **not** suitable for real banking use.
- Because data lives in text files, the app is single-user and not safe for concurrent access.
