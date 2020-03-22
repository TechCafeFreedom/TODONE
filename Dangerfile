# Ignore inline messages which lay outside a diff's range of PR
github.dismiss_out_of_range_messages

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
failure("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# ktlint
checkstyle_format.base_path = Dir.pwd
checkstyle_format.report 'app/build/reports/ktlint/ktlint-main.xml'