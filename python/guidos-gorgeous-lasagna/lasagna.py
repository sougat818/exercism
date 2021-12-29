"""This module helps guido make gorgeous lasagna."""

# 'EXPECTED_BAKE_TIME' constant
EXPECTED_BAKE_TIME = 40
# 'PREPARATION_TIME' constant
#       equal to the time it takes to prepare a single layer
PREPARATION_TIME = 2


def bake_time_remaining(elapsed_bake_time: int):
    """Calculates the bake time remaining.

    :param elapsed_bake_time: int baking time already elapsed.
    :return: int remaining bake time derived from 'EXPECTED_BAKE_TIME'.

    Function that takes the actual minutes the lasagna has been in the oven as
    an argument and returns how many minutes the lasagna still needs to bake
    based on the `EXPECTED_BAKE_TIME`.
    """
    return EXPECTED_BAKE_TIME - elapsed_bake_time


def preparation_time_in_minutes(number_of_layers: int):
    """Calculates the preparation time in minutes.

    :param number_of_layers: int number of layers to bake.
    :return: int preparation time derived from 'PREPARATION_TIME'.

    Function that takes the actual number of layers in the lasagna as
    an argument and returns how many minutes the lasagna need to be baked
    based on the `PREPARATION_TIME`.
    """
    return number_of_layers * PREPARATION_TIME


def elapsed_time_in_minutes(number_of_layers: int, elapsed_bake_time: int):
    """Calculates the elapsed time in minutes.

    :param number_of_layers: int number of layers to bake.
    :param elapsed_bake_time: int the number of minutes the lasagna has been baking in the oven.
    :return: int elapsed time derived from elapsed_bake_time and preparation_time_in_minutes.

    Function that takes the actual number of layers in the lasagna and elapsed bake time as
    arguments and returns how many minutes has elapsed in preparing and baking the lasagna.
    """
    return preparation_time_in_minutes(number_of_layers) + elapsed_bake_time
