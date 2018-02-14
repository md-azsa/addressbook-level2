package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.time.DateTimeException;
import java.time.LocalDate;

public class DateOfBirth {

    public static final String EXAMPLE = "1.2.1993";
    public static final String MESSAGE_DOB_CONSTRAINTS = "Numbers in date of birth should be in between periods and should be valid day, month and year.";
    public static final String DOB_VALIDATION_REGEX = "\\S+\\.\\S+\\.\\S+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public DateOfBirth(String dob, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedName = dob.trim();
        if (!isValidDOB(trimmedName)) {
            throw new IllegalValueException(MESSAGE_DOB_CONSTRAINTS);
        }
        this.value = trimmedName;
    }

    /**
     * Returns true if the given string is a valid person email.
     */
    public static boolean isValidDOB(String test) {

        return test.matches(DOB_VALIDATION_REGEX) && isDateOfValidDayandMonth(test);
    }

    /**
     * Check if the date of birth is valid.
     * Days shouldn't exceed 31 and month shouldn't exceed 12
     * @param s to be validated
     * @return whether arg is a valid date
     */
    private static boolean isDateOfValidDayandMonth(String s) {
        String[] dateProperties  = s.split("\\.");
        int day, month, year;
        try {
            day = dateProperties.length > 2 ? Integer.parseInt(dateProperties[0]) : 1;
            month = dateProperties.length > 1 ? Integer.parseInt(dateProperties[1]) : 1;
            year = Integer.parseInt(dateProperties[2]);
            LocalDate.of(year, month, day);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        } catch (DateTimeException dte) {
            return false;
        }
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateOfBirth // instanceof handles nulls
                && this.value.equals(((DateOfBirth) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
