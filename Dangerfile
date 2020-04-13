# Ignore inline messages which lay outside a diff's range of PR
github.dismiss_out_of_range_messages

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
failure("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# ktlint
checkstyle_format.base_path = Dir.pwd
Dir["**/reports/ktlint-results.xml"].each do |file|
  checkstyle_format.report file
end

# android lint
android_lint.skip_gradle_task = true
android_lint.filtering = true
Dir["*/build/reports/lint-results*.xml"].each do |file|
  android_lint.report_file = file
  android_lint.lint(inline_mode: true)
end

# fail if base branch has commit
has_merge_commit = git.commits.any? { |c| c.message =~ /^Merge branch '#{github.branch_for_base}'/ }
fail "Please rebase because of existence of merge commit" unless has_merge_commit

# LGTM
lgtm.check_lgtm